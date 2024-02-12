# Simple Search Engine(Java)

Simple Search Engine is a simplest implementation of search query for any word from a given file or set of words.

## Description

In this project user will pass the file name as command line argument which contains the set of line from which we have to search words.
Each line contains set of words. User can also pass set of words to search and output will be the set of lines containg those words depending on the matching pattern which user input.

For User following are the set of operation which he can choose:
- Find a person
- Print all people
- Exit

###  Find a person:

If user select this operation then he will get asked about the matching strategy, there he have to specify the matching strategy.
#### Following are the matchng strategy which he can input:
- ANY: It will output the set of line which cntains any of the word provided by user as input.

```
Start test 1
=== Menu ===
1. Find a person
2. Print all people
0. Exit

```
```
>1
Select a matching strategy: ALL, ANY, NONE
> ANY
```
```
Enter a name or email to search all suitable people.
> bob gallien@evilcorp.com
```

Output will be all set of lines which may contain any of the words like "bob", "gallien@evilcorp.com"

- ALL: It will output set of lines which contains all words specified by user as input.

- NONE: It will output set of lines which doesn't contain any of the words specified by user.

### Print all people:

It will output all set of lines provided in the file.

### Exit:
It will exit the program.

## How to use it

### Compilation

- Compile the java project
```
javac SimpleSearhEngine.java
```
### Run
- While running also input the file_name from where program take set of lines
```
java SimpleSearhEngine file.txt
```

After this program will ask user to select any of the operations
```
Start test 1
=== Menu ===
1. Find a person
2. Print all people
0. Exit
```

- Select any of the operations:
For instance select 1
```
>1
```

- Enter the matching pattern:
```
Select a matching strategy: ALL, ANY, NONE
> ANY
```
- Now enter the set of words to search:
```
Enter a name or email to search all suitable people.
> bob gallien@evilcorp.com
```
It will output the result:
```
Angelita Wigington gallien@evilcorp.com
Carlene Bob
Pasquale Gallien gallien@evilcorp.com
Demetria Hostetler gallien@evilcorp.com
Bob Yeh bobyeah@gmail.com
Gerardo Strouth gallien@evilcorp.com
```

- Again the menu reappeared choose any of the operations and get output.
For Instance:
```
=== Menu ===
1. Find a person
2. Print all people
0. Exit

> 2

Kristofer Galley
Fernando Marbury fernando_marbury@gmail.com
Kristyn Nix nix-kris@gmail.com
Regenia Enderle
Malena Gray
Colette Mattei
Wendolyn Mcphillips
Jim Gray
Coreen Beckham
Bob Yeh bobyeah@gmail.com
Shannan Bob stropeshah@gmail.com
Yer Fillion
Margene Resendez marres@gmail.com
Blossom Ambler
Teri Ledet teri_ledet@gmail.com

=== Menu ===
1. Find a person
2. Print all people
0. Exit

> 0

Bye!
```
On selecting `Exit` operation, program will exit.

#### Example 2:

```
=== Menu ===
1. Find a person
2. Print all people
0. Exit

> 2

Kristofer Galley
Fernando Marbury fernando_marbury@gmail.com
Kristyn Nix nix-kris@gmail.com
Regenia Enderle
Malena Gray
Colette Mattei
Wendolyn Mcphillips
Jim Gray
Coreen Beckham
Bob Yeh bobyeah@gmail.com
Shannan Bob stropeshah@gmail.com
Yer Fillion
Margene Resendez marres@gmail.com
Blossom Ambler
Teri Ledet teri_ledet@gmail.com
Dana Baron baron@gmail.com
Abram Goldsberry
Yer Leopold
Stefania Trunzo
Alexis Leopold
Carlene Bob
Oliver Dacruz
Jonie Richter
Pasquale Gallien gallien@evilcorp.com
Verdie Gentle
Gerardo Strouth gallien@evilcorp.com
Agripina Bob
Latricia Niebuhr
Malena Schommer
Drema Leopold
Heide Payeur
Ranae Digiovanni
Simona Pereira
Nick Digiovanni
Angelita Wigington gallien@evilcorp.com
Elin Gray
Dwain Trunzo
Boris Beiler
Remi Malek fsociefy@gmail.com
Demetria Hostetler gallien@evilcorp.com
Nydia Mcduffie
Florencio Defibaugh
Warner Giblin
Bob Mans
Shu Gray
Kaycee Gray
Victorina Froehlich victory@gmail.com
Roseanne Gray
Erica Radford hisam@gmail.com
Elyse Pauling

=== Menu ===
1. Find a person
2. Print all people
0. Exit

> 1

Select a matching strategy: ALL, ANY, NONE
> ALL

Enter a name or email to search all suitable people.
> this text never gonna be matched

No matching people found

=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 2

Kristofer Galley
Fernando Marbury fernando_marbury@gmail.com
Kristyn Nix nix-kris@gmail.com
Regenia Enderle
Malena Gray
Colette Mattei
Wendolyn Mcphillips
Jim Gray
Coreen Beckham
Bob Yeh bobyeah@gmail.com
Shannan Bob stropeshah@gmail.com
Yer Fillion
Margene Resendez marres@gmail.com
Blossom Ambler
Teri Ledet teri_ledet@gmail.com
Dana Baron baron@gmail.com
Abram Goldsberry
Yer Leopold
Stefania Trunzo
Alexis Leopold
Carlene Bob
Oliver Dacruz
Jonie Richter
Pasquale Gallien gallien@evilcorp.com
Verdie Gentle
Gerardo Strouth gallien@evilcorp.com
Agripina Bob
Latricia Niebuhr
Malena Schommer
Drema Leopold
Heide Payeur
Ranae Digiovanni
Simona Pereira
Nick Digiovanni
Angelita Wigington gallien@evilcorp.com
Elin Gray
Dwain Trunzo
Boris Beiler
Remi Malek fsociefy@gmail.com
Demetria Hostetler gallien@evilcorp.com
Nydia Mcduffie
Florencio Defibaugh
Warner Giblin
Bob Mans
Shu Gray
Kaycee Gray
Victorina Froehlich victory@gmail.com
Roseanne Gray
Erica Radford hisam@gmail.com
Elyse Pauling

=== Menu ===
1. Find a person
2. Print all people
0. Exit

> 0
Bye!

```

## Link of project
- [HyperSkill Simple Search Engine](https://hyperskill.org/projects/66?track=17)
- [GitHub Link](https://github.com/barnawalayush/Simple-Search-Engine-Java-)
- [GitLab Link](https://gitlab.griddynamics.net/abarnawal/simple-search-engine)
