Table of Access Modifiers:
Modifier	Same Class	Same Package	Subclass (any package)	Anywhere (any package)
private	        ✅ Yes	      ❌ No	            ❌ No	            ❌ No
default	        ✅ Yes	      ✅ Yes	        ❌ No	            ❌ No
protected       ✅ Yes	      ✅ Yes	        ✅ Yes	            ❌ No
public	        ✅ Yes	      ✅ Yes	        ✅ Yes	            ✅ Yes

    If you don't explicitly specify an access modifier for a member or a class, it implicitly gets default access. This means the member is accessible only within its own package. It's also known as "package-private" access.

The protected keyword provides access to members within the same package, and also to subclasses in any package. It's essentially "package-private + inheritance."

