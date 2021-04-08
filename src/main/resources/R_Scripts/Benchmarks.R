import(java.util.HashMap)

# create a new instance of the HashMap class:
ageMap <- HashMap$new()

# call methods on the new instance:
ageMap$put("Bob", 33)
ageMap$put("Carol", 41)

print(ageMap$size())

age <- ageMap$get("Carol")
cat("Carol is ", age, " years old.\n", sep = "")

# Java primitives and their boxed types
# are automatically converted to R vectors:
typeof(age)

runs <- 3			# Number of times the tests are executed
times <- rep(0, 15); dim(times) <- c(5,3)


cat("\n\n   R Benchmark 2.3\n")
cat("   ===============\n")
cat(c("Number of times each test is run__________________________: ", runs))
cat("\n\n")

runs <- 3

# (0)
timing <- 0
cumulate <- 0; a <- 1:10000000; b <- 10000000:1; 
for (i in 1:runs) {
 timing <- system.time(print((a + b)[6199 + i]))
 print(timing)
 cumulate <- cumulate + timing[3]
}
timing <- cumulate/runs
cat(c("Addition of 2 vectors of size 10000000 each______________________ (sec): ", timing, "\n"))
remove("a", "b")

# (1)
cumulate <- 0; b <- 0
for (i in 1:runs) {
  a <- rnorm(800000)
  invisible(gc())
  timing <- system.time({
    b <- fft(a)
  })
  print(timing)
  cumulate <- cumulate + timing[3]
}
timing <- cumulate/runs
# times[1, 2] <- timing[3]
cat(c("FFT over 800,000 random values______________________ (sec): ", timing, "\n"))
remove("a", "b")


# (2)
cumulate <- 0; a <- 0; b <- 0
for (i in 1:runs) {
  a <- rnorm(2000000)
  invisible(gc())
  timing <- system.time({
    b <- sort(a, method="quick")	
  })
  print(timing)
  cumulate <- cumulate + timing[0] + timing[1]
}
timing <- cumulate/runs
# times[3, 1] <- timing[3]
cat(c("Sorting of 2,000,000 random values__________________ (sec): ", timing, "\n"))
remove("a", "b")

# (3)
cumulate <- 0; a <- 0; b <- 0
for (i in 1:runs) {
  invisible(gc())
  timing <- system.time({
    a <- matrix(rnorm(1500*1500)/10, ncol=1500, nrow=1500);
    b <- t(a);
    dim(b) <- c(7500, 300);
    a <- t(b)
  })
  print(timing)
  cumulate <- cumulate + timing[0] + timing[1]
}
timing <- cumulate/runs
#times[1, 1] <- timing
cat(c("Creation, transpose, deformation of a 150x150 matrix (sec): ", timing, "\n"))
remove("a", "b")


# (4)
cumulate <- 0; a <- 0; b <- 0; c <-0 
for (i in 1:runs) {
  invisible(gc())
  timing <- system.time({
    a <- matrix(rnorm(1500*1500)/10, ncol=1500, nrow=1500);
    b <- matrix(rnorm(1500*1500)/10, ncol=1500, nrow=1500);
    c <- a * b
  })
  print(timing)
  cumulate <- cumulate + timing[0] + timing[1]
}
timing <- cumulate/runs
#times[1, 1] <- timing
cat(c("Multiplication of 2 1500x1500 matrix (sec): ", timing, "\n"))
remove("a", "b");

# (5)
cumulate <- 0; b <- 0
for (i in 1:runs) {
  a <- rnorm(700*700); dim(a) <- c(700, 700)
  invisible(gc())
  timing <- system.time({
    b <- crossprod(a)		# equivalent to: b <- t(a) %*% a
  })
  print(timing)
  cumulate <- cumulate + timing[3]
}
timing <- cumulate/runs
# times[4, 1] <- timing[3]
cat(c("700x700 cross-product matrix (b = a' * a)___________ (sec): ", timing, "\n"))
remove("a", "b")

# (5)
cumulate <- 0; c <- 0; qra <-0
for (i in 1:runs) {
  a <- rnorm(600*600); dim(a) <- c(600,600)
  b <- 1:600
  invisible(gc())
  timing <- system.time({
    qra <- qr(a, tol = 1e-7);
    c <- qr.coef(qra, b)
    #Rem: a little faster than c <- lsfit(a, b, inter=F)$coefficients
  })
  print(timing)
  cumulate <- cumulate + timing[3]
}
timing <- cumulate/runs
# times[5, 1] <- timing[3]
cat(c("Linear regression over a 600x600 matrix (c = a \\ b') (sec): ", timing, "\n"))
remove("a", "b", "c", "qra")