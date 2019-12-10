package com.brent.comparison.testData;

public enum RelationToInsured implements EnumeratedType
{
    APPLICANT("Applicant", "A"), 
    CHILD("Child", "C"), 
    EMPLOYEE("Employee", "E"),
    OTHER("Other", "O"),
    PARENT("Parent", "P"),
    SIBLING("Sibling", "B"),
    SPOUSE("Spouse", "S");
    
    private String code;
    private String description;
 
   private RelationToInsured(String description, String code)
   {
      this.code = code;
      this.description = description;    
   }
   
   @Override
   public String getCode()
   {
      return code;
   }
   
   @Override
   public String getDescription()
   {
      return description;
   }
   
   public static RelationToInsured getByCode(String value)
   { 
      return EnumeratedTypeHelper.getByCode(values(), value);
   }
   
   public static RelationToInsured getByDescription(String value)
   { 
      return EnumeratedTypeHelper.getByDescription(values(), value);
   }

}
