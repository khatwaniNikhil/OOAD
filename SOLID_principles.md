# References
1. https://davecallan.com/what-to-look-for-when-reviewing-code-for-solid-principle-violations/
2. https://www.baeldung.com/java-liskov-substitution-principle
3. https://betterprogramming.pub/5-problems-faced-when-using-solid-design-principles-and-how-to-fix-them-df6dbf3699fb

# Better interpretation of SOLID principles
1. Single-Responsibility Principle (SRP) - Each module has to be responsible for one — and only one — user or stakeholder.



| Signs to look - Code Review  | Pattern violated | Fix
| --- | --- |--- |
| Large classes which contain lots of functionality | Single responsibility principle | Break into smaller with data and behavior on data colocated |
| Long blocks of if/else statements that check an object’s type | Open/closed principle  |  use polymorphism either through interfaces or abstract classes |
| A Subtype Throws an Exception for a Behavior It Can't Fulfill | Liskov substitution principle  | Consider Interface inheritance hierarchy  |
| A Subtype Provides No Implementation for a Behavior It Can't Fulfill | Liskov substitution principle  | Consider Interface inheritance hierarchy  |
Subclass methods that enforce stricter rules on parameters than their base| Liskov substitution principle  | Consider Interface inheritance hierarchy  |
Methods that appear from a signature point of view to operate on a base class (or interface) but then within the method some type checking occurs| Liskov substitution principle  | Consider Interface inheritance hierarchy  |
large (fat) interfaces with a lot of unfocused methods| Interface segregation principle  | Break into multiple interfaces  |
Interfaces whose clients throw NotImplementedException() a lot| Interface segregation principle  | Break into multiple interfaces  |
lot of new statements or dependencies defined within method body | Dependency inversion principle | use container like spring IOC  |


# Real world refactoring example
1. Without open closed principle

![](https://github.com/khatwaniNikhil/OOAD/blob/main/attempt1_without_open_closed_principle.webp)

2. With open closed principle

![](https://github.com/khatwaniNikhil/OOAD/blob/main/attempt2_with_open_closed_principle.webp)

3. With open closed and Liskov Substitution_Principle
   
![](https://github.com/khatwaniNikhil/OOAD/blob/main/attempt3_with_open_closed_Liskov%20Substitution_Principle.webp)



