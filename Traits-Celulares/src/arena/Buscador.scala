package arena

import com.uqbar.commons.collections.Transformer
import java.text.SimpleDateFormat
import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.layout.ColumnLayout
import java.util.Arrays
import org.uqbar.arena.widgets.tables.{Column, Table}
import org.uqbar.arena.widgets.{Button, Control, Label, Panel, Selector, TextBox}
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.{Dialog, WindowOwner}
import org.uqbar.commons.model.{Search, SearchByExample}
import tadp.blocbaster.entidades.Socio
import videoclub.VentanaDeBusqueda

class Buscador(owner:WindowOwner) extends VentanaDeBusqueda(owner) {
	

	override def createMainTemplate(formBuilder:Panel)= {
		this.setTitle("Buscador de Socios");
		this.setTaskDescription("Ingrese los parametros de busqueda");
		super.createMainTemplate(formBuilder);
	}

	override def createMainPanel(): Panel = {
		var formBuilder = super.createMainPanel();
		formBuilder.setWidth(1200);
		return formBuilder;
	}

	override def createFormPanel(mainPanel:Panel)= {
		var searchFormPanel = new Panel(mainPanel);
		searchFormPanel.bindContents(SearchByExample.EXAMPLE);
		searchFormPanel.setLayout(new ColumnLayout(2));

		// Field nombre
		var nombreLabel = new Label(searchFormPanel);
		nombreLabel.setText("Nombre");

		var nombre = new TextBox(searchFormPanel);
		nombre.bindValueToProperty(Socio.NOMBRE);

		// Field direccion
		var direccionLabel = new Label(searchFormPanel);
		direccionLabel.setText("Direccion");

		var direccion = new TextBox(searchFormPanel);
		direccion.bindValueToProperty(Socio.DIRECCION);
		
//		new Selector(searchFormPanel).setContents(Arrays.asList(Socio.Estado.values()), "nombre").bindValueToProperty("estado");
		new Label(searchFormPanel).setText("Estado");
	}

	override def describeResultsGrid(table:Table[Socio]) ={
		var nombreColumn = new Column[Socio](table);
		nombreColumn.setTitle("Nombre");
		nombreColumn.setFixedSize(100);
		nombreColumn.bindContentsToProperty(Socio.NOMBRE);
		// table.add(column);

		var ingresoColumn = new Column[Socio](table);
		ingresoColumn.setTitle("Fecha de ingreso");
		ingresoColumn.setFixedSize(100);
		ingresoColumn.bindContentsToTransformer(new Transformer[Socio, String]() {
		  
			def transform(socio:Socio):String = {
				return new SimpleDateFormat("dd/MM/yyyy").format(socio.getFecha());
			}
		});

		var direccionColumn = new Column[Socio](table);
		direccionColumn.setTitle("Direccion");
		direccionColumn.setFixedSize(200);
		direccionColumn.bindContentsToProperty(Socio.DIRECCION);
	}

	override  def addActions(actionsPanel:Panel)= {
		super.addActions(actionsPanel);

		var nuevoSocio = new Button(actionsPanel);
		nuevoSocio.setCaption("Nuevo Socio");
		nuevoSocio.onClick(new Function(crearSocio));
	}

	// ********************************************************
	// ** Acciones
	// ********************************************************

	def crearSocio() = {
		var crearSocio = new NuevoSocio(this);
		crearSocio.onAccept(new MessageSend(this.getModel(), Search.SEARCH));
		crearSocio.open();
	}

	override def createEditor(selected:Socio) = {null
//		return new ModificarSocioDialog(this, selected);
	}


}
