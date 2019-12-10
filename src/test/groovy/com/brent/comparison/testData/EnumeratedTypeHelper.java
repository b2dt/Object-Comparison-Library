/**
 * 
 */
package com.brent.comparison.testData;

/**
 * <br>
 * @author John Doe
 * @since Jan 24, 2017
 */

public class EnumeratedTypeHelper
{
   public static <T extends EnumeratedType> T getByCode(T [] types, String code)
   {
      for (T type : types)
      {
         if (type.getCode().equals(code))
         {
            return type;
         }
      }
      
      return null;
   }
   
   public static <T extends EnumeratedType> T getByDescription(T [] types, String desc)
   {
      for (T type : types)
      {
         if (type.getDescription().equals(desc))
         {
            return type;
         }
      }
      
      return null;
   }
}
