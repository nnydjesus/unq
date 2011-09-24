package arena.traits

import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ButtonBuilder;
import org.uqbar.arena.widgets.Control;

trait AsDefaultButton extends Control{
  
    override def configure(builder:ControlBuilder) = {
    	super.configure(builder);
    	builder match {
		  case g2: ButtonBuilder => g2.setAsDefault();
    	}
    }

}