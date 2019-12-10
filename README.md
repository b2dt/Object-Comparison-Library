# Object Comparison Library
- created by Brent Thoenen

## Requirements before utilizing this library
All you need to to is set your Key and CompositeKey annotations on your array objects.

### Why?
* Utilize the @Key and @CompositeKey annotations appropriately 
    * these annotations work exactly the same way, but were created for a visual difference to the developer
* The use of these keys is to determine uniqueness of an object array
* Place the annotation(s) on the attribute declaration(s) that you deem as an object's uniqueness
    * If you have an array of any non-comparable object, you will need an annotation somewhere in that object
    * Failure to do so will result in an exception called `NoKeyOnArrayException`

Example:

Orig Array |  | New Array
--- | --- | ---
`Object 1` | *changes to* | `Object 3`
`Object 2` | *==* | `Object 2`
`Object 3` | *changes to* | `Object 1`

With this example, I have to have an identifier that object 1 changed to object 3, and vice versa, hence the @Key and @CompositeKey annotations. Without those annotations, if i was checking by object existence, there would be no way to tell that something changed.

* You can utilize these annotation on multiple fields to help determine what you would consider unique in the array

On top of that, if given any array of objects has additions and deletions, or is sorted differently, there's no way to know which compares to what

## How to utilize this library:
* Compare class provides the content that you should mostly be looking for
    * Diff Method
    * Flatten Method

### Diff Method
* This method will give you a changeWrapper object that contains a list of comparable changes at that object's level, as well as nested changes of non-comparable objects that are also of ChangeWrapper type.
* This structure will give you a more flexible way to manipulate the data in comparison to the flatten functionality, but is a little more complex structure

### Flatten Method
* This method will take all your object changes and display them at a single level list of FlatChange object type.
    * FlatChange object contains old and new value, a changeType (added, deleted, changed), where the change existed in the object tree, and the attribute name
* This format helps you more clearly see the changes and where they existed, but lacks object structure

12/2/2019 Updates
- Added an annotation called ExcludeFromCompare to exclude certain attributes from comparison.
- Found a need to know annotations on a field. Added a List of CustomAnnotation objects that will pick up all attribute-level annotations, whether it's comparable or not.