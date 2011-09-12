package concept

import traits.Message
import traits.Call

class Phone(aNumber: Int) extends Mobile with Message with Call{
  
  override def number = aNumber
}