package com.warfactory.dpscalc.model;

/**
 * Model for calculating total DPS
 */
public class Dps {

	/**
	 * Weapon dps, as displayed in weapons's property
	 */
	protected int weaponDps;

	/**
	 * Character main attribute
	 */
	private int mainAttribute;

	/**
	 * Increased attack speed percentage, from items other than weapon. 1 means
	 * +1% attack speed.
	 * 
	 */
	private double iasPercent;

	/**
	 * Critical hit chance. between 0 and 1. 1 means 100% critical hit rate
	 */
	private double critChance;

	/**
	 * Critical hit damage increase percentage. 1 means +100% critical damage.
	 */
	private double critDamage;

	public Dps() {

	}

	/**
	 * Copy ctor
	 * 
	 * @param that
	 */
	public Dps(Dps that) {
		this.setWeaponDps(that.getWeaponDps());
		this.setMainAttribute(that.getMainAttribute());
		this.setIasPercent(that.getIasPercent());
		this.setCritChance(that.getCritChance());
		this.setCritDamage(that.getCritDamage());
	}

	public int getDps() {
		double mainAttributeFactor = 1 + mainAttribute / 100.0;
		// IAS is nerfed by 50% in v1.0.3
		double iasFactor = 1 + iasPercent / 100.0 * 0.5;
		double critHitFactor = 1 + critChance * critDamage;
		return (int) Math.round(getTotalWeaponDps() * mainAttributeFactor * iasFactor * critHitFactor);
	}

	public double getTotalWeaponDps() {
		return weaponDps;
	}

	public int getWeaponDps() {
		return weaponDps;
	}

	public void setWeaponDps(int weaponDps) {
		this.weaponDps = weaponDps;
	}

	public double getIasPercent() {
		return iasPercent;
	}

	public void setIasPercent(double iasPercent) {
		this.iasPercent = iasPercent;
	}

	public double getCritChance() {
		return critChance;
	}

	public void setCritChance(double critChance) {
		if (critChance > 1) {
			critChance = 1;
		}
		this.critChance = critChance;
	}

	public double getCritDamage() {
		return critDamage;
	}

	public void setCritDamage(double critDamage) {
		this.critDamage = critDamage;
	}

	public int getMainAttribute() {
		return mainAttribute;
	}

	public void setMainAttribute(int mainAttribute) {
		this.mainAttribute = mainAttribute;
	}

}
