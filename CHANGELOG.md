# Change Log
All notable changes to this project will be documented in this file.
This project does its best to adhere to [Semantic Versioning](http://semver.org/).


--------
###[0.2.1](N/A) - 2016-09-18
#### Added
* Added more ArrayUtil unit tests
* Improved documentation

#### Changed
* Renamed local repository to JArrays to match remote repository name
* Updated compiled jar path to match new bin/ convention and new repository name
* Renamed ArrayTests -> ArrayUtilTests
* ArrayUtil.reverse() returns the input array

#### Fixed
* ArrayUtil.reverse() ignoring 'offset' argument


--------
###[0.2.0](https://github.com/TeamworkGuy2/JArrays/commit/ea6a81a33eed57c2b0ff44ada159e8614571017b) - 2016-06-23
#### Added
* Added/moved missing ArrayManager template and template generator from JCollectionUtil
#### Changed
* ArrayManaged renamed ArrayManager
* Renamed ArrayManager methods:
  * remove() -> removeValue()
  * expandArray() -> expand()


--------
###[0.1.2](https://github.com/TeamworkGuy2/JArrays/commit/015597bba97bdb8879daaedefd002aa4e0a6b870) - 2016-04-13
#### Fixed
* Fixed ArrayUtil.map() bug, added required component type argument if no destination array is provided


--------
###[0.1.1](https://github.com/TeamworkGuy2/JArrays/commit/08b01fa0b14d7b52f19207846e6064dbace083d9) - 2016-04-12
#### Added
* Added ArrayUtil.map()
* Additional tests


--------
###[0.1.0](https://github.com/TeamworkGuy2/JArrays/commit/33aef620694fdab592a24dc57323a2cfde72165d) - 2016-01-19
#### Added
* Initial commit of static array utility classes moved from jcollection-util
