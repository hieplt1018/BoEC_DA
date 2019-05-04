/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "Electronics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Electronics.findAll", query = "SELECT e FROM Electronics e"),
    @NamedQuery(name = "Electronics.findByWarranly", query = "SELECT e FROM Electronics e WHERE e.warranly = :warranly"),
    @NamedQuery(name = "Electronics.findByScreenSize", query = "SELECT e FROM Electronics e WHERE e.screenSize = :screenSize"),
    @NamedQuery(name = "Electronics.findByResolution", query = "SELECT e FROM Electronics e WHERE e.resolution = :resolution"),
    @NamedQuery(name = "Electronics.findByDisplayTech", query = "SELECT e FROM Electronics e WHERE e.displayTech = :displayTech"),
    @NamedQuery(name = "Electronics.findByHdr", query = "SELECT e FROM Electronics e WHERE e.hdr = :hdr"),
    @NamedQuery(name = "Electronics.findBySoundBar", query = "SELECT e FROM Electronics e WHERE e.soundBar = :soundBar"),
    @NamedQuery(name = "Electronics.findByColor", query = "SELECT e FROM Electronics e WHERE e.color = :color"),
    @NamedQuery(name = "Electronics.findByModel", query = "SELECT e FROM Electronics e WHERE e.model = :model"),
    @NamedQuery(name = "Electronics.findByStorage", query = "SELECT e FROM Electronics e WHERE e.storage = :storage"),
    @NamedQuery(name = "Electronics.findByRam", query = "SELECT e FROM Electronics e WHERE e.ram = :ram"),
    @NamedQuery(name = "Electronics.findByOs", query = "SELECT e FROM Electronics e WHERE e.os = :os"),
    @NamedQuery(name = "Electronics.findBySystemMemory", query = "SELECT e FROM Electronics e WHERE e.systemMemory = :systemMemory"),
    @NamedQuery(name = "Electronics.findByHeight", query = "SELECT e FROM Electronics e WHERE e.height = :height"),
    @NamedQuery(name = "Electronics.findByLaptopAccessories", query = "SELECT e FROM Electronics e WHERE e.laptopAccessories = :laptopAccessories"),
    @NamedQuery(name = "Electronics.findByDoorHingers", query = "SELECT e FROM Electronics e WHERE e.doorHingers = :doorHingers"),
    @NamedQuery(name = "Electronics.findByBatteryInclude", query = "SELECT e FROM Electronics e WHERE e.batteryInclude = :batteryInclude"),
    @NamedQuery(name = "Electronics.findByCapacity", query = "SELECT e FROM Electronics e WHERE e.capacity = :capacity"),
    @NamedQuery(name = "Electronics.findByBatteryRequired", query = "SELECT e FROM Electronics e WHERE e.batteryRequired = :batteryRequired"),
    @NamedQuery(name = "Electronics.findBySize", query = "SELECT e FROM Electronics e WHERE e.size = :size"),
    @NamedQuery(name = "Electronics.findByEnergyUse", query = "SELECT e FROM Electronics e WHERE e.energyUse = :energyUse"),
    @NamedQuery(name = "Electronics.findById", query = "SELECT e FROM Electronics e WHERE e.id = :id"),
    @NamedQuery(name = "Electronics.findByName", query = "SELECT e FROM Electronics e WHERE e.name = :name"),
    @NamedQuery(name = "Electronics.findByDes", query = "SELECT e FROM Electronics e WHERE e.des = :des"),
    @NamedQuery(name = "Electronics.findByPrice", query = "SELECT e FROM Electronics e WHERE e.price = :price"),
    @NamedQuery(name = "Electronics.findByDiscountID", query = "SELECT e FROM Electronics e WHERE e.discountID = :discountID"),
    @NamedQuery(name = "Electronics.findByImage", query = "SELECT e FROM Electronics e WHERE e.image = :image"),
    @NamedQuery(name = "Electronics.findByElectronicCategory", query = "SELECT e FROM Electronics e WHERE e.electronicCategory = :electronicCategory")})
public class Electronics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Warranly")
    private String warranly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ScreenSize")
    private float screenSize;
    @Size(max = 255)
    @Column(name = "Resolution")
    private String resolution;
    @Size(max = 255)
    @Column(name = "DisplayTech")
    private String displayTech;
    @Size(max = 255)
    @Column(name = "Hdr")
    private String hdr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoundBar")
    private boolean soundBar;
    @Size(max = 255)
    @Column(name = "Color")
    private String color;
    @Size(max = 255)
    @Column(name = "Model")
    private String model;
    @Column(name = "Storage")
    private Integer storage;
    @Column(name = "RAM")
    private Integer ram;
    @Size(max = 255)
    @Column(name = "OS")
    private String os;
    @Column(name = "SystemMemory")
    private Integer systemMemory;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Height")
    private Float height;
    @Column(name = "LaptopAccessories")
    private Boolean laptopAccessories;
    @Size(max = 255)
    @Column(name = "DoorHingers")
    private String doorHingers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BatteryInclude")
    private boolean batteryInclude;
    @Size(max = 255)
    @Column(name = "Capacity")
    private String capacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BatteryRequired")
    private boolean batteryRequired;
    @Size(max = 255)
    @Column(name = "Size")
    private String size;
    @Column(name = "EnergyUse")
    private Float energyUse;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ID")
    private String id;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private float price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiscountID")
    private int discountID;
    @Size(max = 255)
    @Column(name = "Image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ElectronicCategory")
    private int electronicCategory;

    public Electronics() {
    }

    public Electronics(String id) {
        this.id = id;
    }

    public Electronics(String id, float screenSize, boolean soundBar, boolean batteryInclude, boolean batteryRequired, float price, int discountID, int electronicCategory) {
        this.id = id;
        this.screenSize = screenSize;
        this.soundBar = soundBar;
        this.batteryInclude = batteryInclude;
        this.batteryRequired = batteryRequired;
        this.price = price;
        this.discountID = discountID;
        this.electronicCategory = electronicCategory;
    }

    public String getWarranly() {
        return warranly;
    }

    public void setWarranly(String warranly) {
        this.warranly = warranly;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDisplayTech() {
        return displayTech;
    }

    public void setDisplayTech(String displayTech) {
        this.displayTech = displayTech;
    }

    public String getHdr() {
        return hdr;
    }

    public void setHdr(String hdr) {
        this.hdr = hdr;
    }

    public boolean getSoundBar() {
        return soundBar;
    }

    public void setSoundBar(boolean soundBar) {
        this.soundBar = soundBar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(Integer systemMemory) {
        this.systemMemory = systemMemory;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Boolean getLaptopAccessories() {
        return laptopAccessories;
    }

    public void setLaptopAccessories(Boolean laptopAccessories) {
        this.laptopAccessories = laptopAccessories;
    }

    public String getDoorHingers() {
        return doorHingers;
    }

    public void setDoorHingers(String doorHingers) {
        this.doorHingers = doorHingers;
    }

    public boolean getBatteryInclude() {
        return batteryInclude;
    }

    public void setBatteryInclude(boolean batteryInclude) {
        this.batteryInclude = batteryInclude;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public boolean getBatteryRequired() {
        return batteryRequired;
    }

    public void setBatteryRequired(boolean batteryRequired) {
        this.batteryRequired = batteryRequired;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Float getEnergyUse() {
        return energyUse;
    }

    public void setEnergyUse(Float energyUse) {
        this.energyUse = energyUse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getElectronicCategory() {
        return electronicCategory;
    }

    public void setElectronicCategory(int electronicCategory) {
        this.electronicCategory = electronicCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Electronics)) {
            return false;
        }
        Electronics other = (Electronics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Electronics[ id=" + id + " ]";
    }
    
}
