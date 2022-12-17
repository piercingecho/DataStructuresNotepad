import java.util.Stack;

public class History
{



    /**
       Notepad will call this function when thier text changes.

       deletion is a boolean that indicates if the action was a deletion of text or the insertion of text.
       position is the postion where the change took place
       Change is the string of characters that is the change.
     */
   //Making a class for the undo and redo stacks
   
   //public UndoStack undoStack;
   //public RedoStack redoStack;
   private Stack<NotePadChange> undoStack;
   private Stack<NotePadChange> redoStack;
   
   
   public History()
   {
      //this.undoStack= new UndoStack();
      //this.redoStack= new RedoStack();
      this.undoStack = new Stack<NotePadChange>();
      this.redoStack = new Stack<NotePadChange>();
   } 
     
   public void addEvent(boolean deletion, int position, String change)
   {
      undoStack.push(new NotePadChange(deletion, position, change));
      if (hasReDoData())
      {
         //This deletes all the items in the stack whenever an event has occured  
         redoStack=new Stack<NotePadChange>();
      }
   }


    /**
       Notepad will call this function when it wishes to undo the last event.

       note is a variable to the Notepad that called this function
     */
   public void undoEvent(NotePad note)
   {
      if(hasUndoData())
      {
         NotePadChange undone=undoStack.pop();
         redoStack.push(undone);
         if (undone.isDeletion())
         {
            note.insert(undone.getPosition(),undone.getChange());
         }
         else
         {
            note.remove(undone.getPosition(),undone.getChange().length());
         }
      }     
   }


    /**
       Notepad will call this function when it wishes to redo the last event that was undone.
       Note that new actions should clear out events that can be "redone"
       note is a variable to the Notepad that called this function
     */
   public void redoEvent(NotePad note)
   {
   	if(hasReDoData())
      {
         NotePadChange redone=redoStack.pop();
         undoStack.push(redone);
         if (redone.isDeletion())
         {
            note.remove(redone.getPosition(),redone.getChange().length());
         }
         else
         {
            note.insert(redone.getPosition(),redone.getChange());
         }
      } 
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasUndoData()
   {
       //return !undoStack.undoChanges.isEmpty();
      return !undoStack.isEmpty();
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasReDoData()
   {
       //return !redoStack.redoChanges.isEmpty();
      return !redoStack.isEmpty();
   }
	

}
