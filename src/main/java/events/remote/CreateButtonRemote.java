package events.remote;

import coms362.cards.streams.Marshalls;
import model.Location;

public class CreateButtonRemote implements Marshalls {
	
	private String id;
	private String label;
	private Location loc;
	private String evtName;
	
	public CreateButtonRemote(String id, String label, Location p, String evtName){
		this.id = id;
		this.label = label;
		loc = p; 
		this.evtName = evtName;
	}

	public String marshall() {
		return String.format(""
			+ "var btn=$('<button>%s</button>')"
			+ ".prop('id', '%s')"
			+ ".click(function(){"
			+ "  doSend(JSON.stringify({event: '%s'}));\n"
			+ "})\n;"
			+ "$('#card-table').append(btn);\n",			
			label, id, evtName
		);
	}

	public String stringify() {
		return "CreateButton "+label;
	}

}
