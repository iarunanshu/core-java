
***

### 🔒 String Immutability and the String Pool

* **Immutability**: Once a **String** object is created, its content cannot be changed. Methods that appear to modify a string, like `concat()` or `toLowerCase()`, actually return a new `String` object. The original object remains unaltered.
* **String Pool**: This is a special area within the **Heap memory** that stores a single copy of each unique **String literal**. This optimizes memory use.
    * The `intern()` method can be used to explicitly add a `String` object to the pool, or return a reference to an existing one if it's already there.

***

### 📝 Creating and Combining Strings

* **Creation**: String literals are created with double quotes, like `"Hello"`.
* **Concatenation**:
    * The `+` operator or `concat()` method appends one string to another, creating a **new `String`** object.
* **String Builders**:
    * **`StringBuilder`**: Used for mutable string operations when **thread safety is not a concern**. It's faster than `StringBuffer`.
    * **`StringBuffer`**: Used for mutable string operations when **thread safety is required** (it's synchronized).
* **Joining**:
    * The static `String.join()` method (Java 8+) combines multiple string elements with a specified delimiter.

***

### 📏 Essential String Methods

* **Length**: `length()` returns the number of characters in the string.
* **Whitespace**: `trim()` removes leading and trailing whitespace.
* **Case Conversion**:
    * `toLowerCase()` returns a new string with all characters in lowercase.
    * `toUpperCase()` returns a new string with all characters in uppercase.
* **Substrings**:
    * `substring(int beginIndex)` extracts a part of a string from the given index to the end.
    * `substring(int beginIndex, int endIndex)` extracts a part from the begin index (inclusive) to the end index (exclusive).

***

### 🧐 String Comparison

* `==` operator: Compares the **memory addresses** (references) of two strings. It checks if they are the exact same object.
* `equals()` method: Compares the **content** of two strings. This is the correct method for checking if two strings have the same value.
* `equalsIgnoreCase()`: Compares content, but **ignores case differences**.

***

### 🔎 Searching and Manipulation

* **Searching**:
    * `indexOf()`: Finds the first occurrence of a character or substring.
    * `lastIndexOf()`: Finds the last occurrence.
    * `contains()`: Checks if a string contains a specific sequence.
* **Character Access**: `charAt(int index)` returns the character at a specific position.
* **Replacement**:
    * `replace()`: Replaces all occurrences of a character or sequence.
    * `replaceAll()` and `replaceFirst()`: Use **regular expressions** to replace matching substrings.
* **Splitting**: `split(String regex)` divides a string into an array of strings based on a delimiter.


***

### 🔄 Type Conversion

* **String to Primitive**: Use the static `parse` methods of wrapper classes (e.g., `Integer.parseInt("123")`, `Double.parseDouble("3.14")`).
* **Primitive to String**: Use the static `String.valueOf()` method, which is overloaded for various data types.

***

### 🔤 Formatting and Special Characters

* **Escape Sequences**: Special characters like `\n` (newline), `\t` (tab), and `\"` (double quote) are used within string literals. Unicode characters can be represented with `\uXXXX`.
* **Formatted Output**:
    * `String.format()`: Returns a formatted string.
    * `System.out.printf()`: Prints a formatted string to the console.
    * Both use **format specifiers** (e.g., `%s` for string, `%d` for integer) to control the output.

The intern() method can be used to explicitly add a String object (that might have been created outside the String Pool) to the String Pool. If a String with the same content already exists in the pool, it returns a reference to that pooled String. Otherwise, it adds the String to the pool and returns a reference to it.

The concat() method appends one String to the end of another, creating a new String object. It's one way to combine Strings.

Escape sequence characters (e.g., \n for newline, \t for tab, \" for double quote, \\ for backslash) are special characters used within String literals to represent non-printable characters or characters that have special meaning in Java syntax. You also learned about representing Unicode characters using \uXXXX format.

The length() method of the String class returns the number of characters (length) in the String

Comparing Strings in Java requires careful attention:

== operator: Compares references (memory addresses) of String objects. It checks if two references point to the exact same object in memory.
equals() method: Compares the content (character sequence) of String objects. This is almost always what you want when checking if two Strings have the same value.
equalsIgnoreCase() method: Compares the content of String objects, ignoring case differences.

The charAt(int index) method returns the character at the specified index within the String. 

The isEmpty() method returns true if the String has a length of 0, and false otherwise

The toLowerCase() and toUpperCase() methods return a new String with all characters converted to lowercase or uppercase, respectively. The original String remains unchanged (due to immutability).

The String.valueOf() method (overloaded for various primitive types and objects) is used to convert different data types (like int, double, boolean, char[], objects, etc.) into their String representation

Methods for searching within a String include:
indexOf(char ch) / indexOf(String str): Returns the index of the first occurrence of the specified character or substring, or -1 if not found.
lastIndexOf(char ch) / lastIndexOf(String str): Returns the index of the last occurrence.
contains(CharSequence s): Returns true if the String contains the specified sequence of characters.

Trimming a String
The trim() method returns a new String with leading and trailing whitespace characters removed. It does not affect whitespace within the String.

The substring() methods extract a portion of a String:
substring(int beginIndex): Returns a new String from beginIndex to the end.
substring(int beginIndex, int endIndex): Returns a new String from beginIndex (inclusive) to endIndex (exclusive).

The replace() methods are used to substitute characters or substrings:
replace(char oldChar, char newChar): Replaces all occurrences of oldChar with newChar.
replace(CharSequence target, CharSequence replacement): Replaces all occurrences of target with replacement.
replaceAll(String regex, String replacement): Replaces all substrings that match the given regular expression.
replaceFirst(String regex, String replacement): Replaces only the first substring that matches the given regular expression.

The split(String regex) method splits a String into an array of Strings based on a given delimiter (regular expression).

Introduced in Java 8, String.join(CharSequence delimiter, CharSequence... elements) and String.join(CharSequence delimiter, Iterable<? extends CharSequence> elements) allow you to concatenate multiple String elements with a specified delimiter in between them.

The format() Method in String & System.out.printf() Method & Trying printf() Method
The String.format(String format, Object... args) method returns a formatted String using a format string and arguments, similar to C's sprintf.

System.out.printf(String format, Object... args) prints a formatted string to the console. Both use format specifiers (e.g., %s for String, %d for integer, %f for float) to control output formatting.

String objects in Java are immutable. This means once a String object is created, its content cannot be changed. Any operation that appears to modify a String (like concat(), replace(), toLowerCase()) actually creates and returns a new String object, leaving the original String untouched in memory. This immutability contributes to thread safety and security.

StringBuilder: For mutable String operations when thread safety is not a concern (faster).
StringBuffer: For mutable String operations when thread safety is required (synchronized, slightly slower).

Converting String to Primitive Data Type Values
convert String representations of numbers or booleans into their corresponding primitive data types. This is done using the static parse methods of the wrapper classes (e.g., Integer.parseInt("123"), Double.parseDouble("3.14"), Boolean.parseBoolean("true")).





