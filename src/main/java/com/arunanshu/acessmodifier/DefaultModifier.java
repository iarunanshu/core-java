package com.arunanshu.acessmodifier;

public class DefaultModifier {
    /*
    Table of Access Modifiers:
    Modifier	Same Class	Same Package	Subclass (any package)	Anywhere (any package)
    private	        ✅ Yes	      ❌ No	            ❌ No	            ❌ No
    default	        ✅ Yes	      ✅ Yes	        ❌ No	            ❌ No
    protected       ✅ Yes	      ✅ Yes	        ✅ Yes	            ❌ No
    public	        ✅ Yes	      ✅ Yes	        ✅ Yes	            ✅ Yes

    If you don't explicitly specify an access modifier for a member or a class, it implicitly gets default access. This means the member is accessible only within its own package. It's also known as "package-private" access.
     */
    public void connection(){
        System.out.println();
    }

    public  int x;


}

class defaultmod{
    public String databaseUrl = "jdbc:mysql://localhost:3306/mydb"; // Default field access
    void connect() { // Default method access
        System.out.println("Connecting to " + databaseUrl);
        // ... actual connection logic
    }
}