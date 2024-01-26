# This is a simple workflow setup on Eclipse

If these steps work - you should be able to run any program.

### 1. Install for M1 Mac

link : https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2023-12/R/eclipse-java-2023-12-R-macosx-cocoa-aarch64.dmg

Follow instructions to install: till you get the app open

### 2. Get Package Explorer working

You want to see all files:  make sure Package Explorer is visible. Search on help tab at top : look for `Show View > package explorer`

### 3. Create a JAVA project

a. File > New > Java Project - Name it `project_sample`
b. We like folders: right click on `project_sample`> create new folder > name it `folder_sample`
c. Add files now : right click on `folder_sample` > create new java file > name it `MyClass.java` (or just MyClass - Eclipse adds the rest)
d. to `MyClass.java`, add code : 
```
package folder_sample;

public class MyClass {
    public void displayMessage() {
        System.out.println("Hello from MyClass!");
    }
}
```
e. Similarly, create another java file MainClass.java. Add the following code : 
```
package folder_sample;

public class MainClass {
	public static void main(String[] args) {
        MyClass myObj = new MyClass();
        myObj.displayMessage();
    }
}
```
f. to run this : Just click on green arrow Run button on top while being on the file MainClass. You should see : `Hello from MyClass!` printed in the bottom.





