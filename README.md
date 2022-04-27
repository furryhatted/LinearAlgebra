# LinearAlgebra
Repository contains structures and methods to execute linear algebra operations (matrix multiplication etc)

## Matrix class
Matrix implementation using List as backing filed for elements
Implements methods for by-row and by-column access to elements

Operations supported:
 * matrix addition ( a + b  or a.plus(b) ) 
 * matrix subtraction ( a - b  or a.minus(b) ) 
 * value addition ( a + b  or a.plus(b) )
 * value subtraction ( a - b  or a.minus(b) )
 * matrix multiplication ( a * b  or a.times(b) )
 * vector multiplication ( a * b  or a.times(b) )
 * value multiplication ( a * b  or a.times(b) )
 * hadamard product ( a.hadamard(b) )
 * transpose (!a or a.not() )
 
 ## Vector class
Vector implementation using List as backing filed for elements
Implements methods for accessing elements

Operations supported:
 * vector addition
 * vector subtraction
 * value addition
 * value subtraction
 * matrix multiplication
 * vector multiplication
 * value multiplication
 * hadamard product
 * dot product
