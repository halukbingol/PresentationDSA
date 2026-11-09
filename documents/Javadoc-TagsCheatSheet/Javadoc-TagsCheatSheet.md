# Javadoc Tags Cheat Sheet

*v2025-11-13*

[ToC]

Javadoc tags provide structured documentation for Java classes, methods, fields, and more. Below is a quick reference for common tags.

## 1. Class-Level Tags

Tag |Description	|Example
:--- |:--- |:---
`@author`	|Specifies the author of the class.	|@author John Doe
`@version`	|Indicates the version of the class.	|@version 1.0
`@since`	|Specifies when the class was introduced.	|@since 2023-10-01
`@deprecated`	|Marks the class as obsolete (provide reason).	|@deprecated Use {@link NewClass} instead.

**Example:**

```java
/**
 * Represents a user in the system.
 * 
 * @author Jane Smith
 * @version 2.1
 * @since 2020-05-10
 */
public class User { ... }
```

## 2. Method-Level Tags

Tag |Description	|Example
:--- |:--- |:---
`@param`	|Describes a method parameter.	|@param username The user's login name
`@return`	|Explains the return value.	|@return {@code true} if successful
`@throws` / `@exception`	|Documents exceptions thrown.	|@throws IOException On file error
`@deprecated`	|Marks a method as obsolete.	|@deprecated Use {@link #newMethod()} instead.
`@see`	|Links to related methods/classes.	|@see User#login()
`@hidden`	|Excludes from Javadoc (Java 9+).	|@hidden Internal use only

**Example:**

```java
/**
 * Logs in a user.
 * 
 * @param username The user's login name
 * @param password The user's password
 * @return {@code true} if login succeeds
 * @throws AuthenticationException If credentials are invalid
 * @see User#logout()
 */
public boolean login(String username, String password) throws AuthenticationException { ... }
```

## 3. Field-Level Tags

Tag |Description	|Example
:--- |:--- |:---
`@deprecated`	|Marks a field as obsolete.	|@deprecated Use {@link #NEW_FIELD}
`@value`	|Shows the constant’s value (for static final).	|@value 3.14159

**Example:**

```java
/**
 * Default timeout (milliseconds).
 * @value 5000
 */
public static final int TIMEOUT = 5000;
```

## 4. Inline Tags (Inside Descriptions)

Tag |Description	|Example
:--- |:--- |:---
`{@code}`	|Formats text as code (no HTML escape).	|{@code List<String>}
`{@link}`	|Links to another class/method.	|{@link #someMethod()}
`{@literal}`	|Displays text literally (no HTML parsing).	|{@literal <T>}
`{@docRoot}`	|Relative path to Javadoc root.	|{@docRoot}/images/logo.png

**Example:**

```java
/**
 * Use {@code System.out.println()} for debugging.
 * See {@link java.util.Collections#sort(List)}.
 */
```

## 5. Package-Level Tags

Create a package-info.java file in the package directory:

```java
/**
 * Provides networking utilities for HTTP requests.
 * 
 * @author Dev Team
 * @version 1.2
 */
package com.example.network;
```

## 6. Key Notes

- Required Tags:

	- `@param` for all non-void method parameters.

	- `@return` for non-void methods.

	- `@throws` for documented exceptions.

- HTML Support:

	- Use `<b>`, `<i>`, `<ul>` in descriptions.

- Command-Line:

	- Generate Javadoc:

		```bash
		javadoc -d docs -author -version MyClass.java
		```
- Common Pitfalls

	- **Missing** @param/@return: Causes warnings during Javadoc generation.

	- **Broken** {@link}: Verify correct syntax (e.g., {@link ClassName#method}).

	- **No Newline After** /**: The first line should be a summary.

## Example (All Tags Combined)

```java
/**
 * A sample class demonstrating Javadoc tags.
 * 
 * @author Alice
 * @version 1.5
 * @since 2023-01-01
 */
public class Demo {
    /**
     * The default value.
     * @value 10
     */
    public static final int DEFAULT = 10;

    /**
     * Calculates the sum of two numbers.
     * 
     * @param a First number
     * @param b Second number
     * @return Sum of {@code a} and {@code b}
     * @throws IllegalArgumentException If {@code a < 0}
     * @see Math#addExact(int, int)
     */
    public int add(int a, int b) throws IllegalArgumentException { ... }
}
```

See [Oracle’s Javadoc Guide](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html).
