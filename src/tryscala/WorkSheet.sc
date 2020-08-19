// Defining functions
def square(x: Int) = x* x
square(4)

// Arrays
val greetStrings = new Array[String](3)
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"

for(i <-0 to 2) print(greetStrings(i))
for(_ <-0 to 2) print(greetStrings)
greetStrings.foreach(arg => print(arg))
greetStrings.foreach(print)

val endGreet = Array("Leave", " me", " alone", ", ", "world!")
endGreet.foreach(print)

// Lists
val oneTow = List(1, 2)
val threeFour = List(3, 4)
val oneTowThreeFour = oneTow ::: threeFour
println(oneTowThreeFour)

val oneTwoThree = 1 :: 2 :: 3 :: Nil
println(oneTwoThree)















