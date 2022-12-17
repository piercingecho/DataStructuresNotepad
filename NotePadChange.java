class NotePadChange
{
   private boolean deletion;
   private int changePos;
   private String change;
   
   public NotePadChange(boolean deletion, int changePos, String change)
   {
      this.deletion = deletion;
      this.changePos = changePos;
      this.change = change;
   }
   
   public boolean isDeletion()
   {
      return deletion;
   }
   
   public int getPosition()
   { 
      return changePos;
   }
   
   public String getChange()
   {
      return change;
   }
}