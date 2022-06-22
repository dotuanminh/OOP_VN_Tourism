package hust.soict.globalict.entity.tourism.man_made_attraction.modern_architecture;

import hust.soict.globalict.entity.tourism.man_made_attraction.ManmadeAttraction;

public class ModernArchitecture extends ManmadeAttraction {

	private String openingDate;
	private String owner;

	public ModernArchitecture() {
		super();

		this.openingDate = "?place dbp:openingDate ?openingDate.";
		this.owner = "?place dbp:owner ?owner.";
	}

	public String getOpeningDate() {
		return this.openingDate;
	}

	public String getOwner() {
		return this.owner;
	}
}
