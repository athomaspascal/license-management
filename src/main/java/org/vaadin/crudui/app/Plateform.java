package org.vaadin.crudui.app;


import javax.persistence.*;

@Entity
@Table(name = "plateform", schema = "demo")
public class Plateform {
    private String name;
    private String os;
    private int idPlateform;
    private String osLevel;
    private String osName;
    private Integer cpuQty;
    private Integer coreSize;
    private Integer memory;
    private Integer storageMax;
    private Integer frequency;
    private Integer power;
    private String  linuxrelease;
    private Integer nbIpAdresse;
    private String  env;

    @Basic
    @Column(name = "env")
    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }



    @Basic
    @Column(name = "nb_ip")
    public Integer getNbIpAdresse() {
        return nbIpAdresse;
    }

    public void setNbIpAdresse(Integer nbIpAdresse) {
        this.nbIpAdresse = nbIpAdresse;
    }




    @Basic
    @Column(name = "linux_release")
    public String getLinuxrelease() {
        return linuxrelease;
    }

    public void setLinuxrelease(String linuxrelease) {
        this.linuxrelease = linuxrelease;
    }



    @Basic
    @Column(name = "power")
    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Basic
    @Column(name = "frequency")
    public Integer getFrequency() {
        return frequency;
    }


    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }



    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "os")
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Id
    @Column(name = "id_plateform")
    public int getIdPlateform() {
        return idPlateform;
    }

    public void setIdPlateform(int idPlateform) {
        this.idPlateform = idPlateform;
    }

    @Basic
    @Column(name = "os_level")
    public String getOsLevel() {
        return osLevel;
    }

    public void setOsLevel(String osLevel) {
        this.osLevel = osLevel;
    }

    @Basic
    @Column(name = "os_name")
    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    @Basic
    @Column(name = "cpu_qty")
    public Integer getCpuQty() {
        return cpuQty;
    }

    public void setCpuQty(Integer cpuQty) {
        this.cpuQty = cpuQty;
    }

    @Basic
    @Column(name = "core_size")
    public Integer getCoreSize() {
        return coreSize;
    }

    public void setCoreSize(Integer coreSize) {
        this.coreSize = coreSize;
    }

    @Basic
    @Column(name = "memory")
    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    @Basic
    @Column(name = "storage_max")
    public Integer getStorageMax() {
        return storageMax;
    }

    public void setStorageMax(Integer storageMax) {
        this.storageMax = storageMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plateform that = (Plateform) o;

        if (idPlateform != that.idPlateform) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (os != null ? !os.equals(that.os) : that.os != null) return false;
        if (osLevel != null ? !osLevel.equals(that.osLevel) : that.osLevel != null) return false;
        if (osName != null ? !osName.equals(that.osName) : that.osName != null) return false;
        if (cpuQty != null ? !cpuQty.equals(that.cpuQty) : that.cpuQty != null) return false;
        if (coreSize != null ? !coreSize.equals(that.coreSize) : that.coreSize != null) return false;
        if (memory != null ? !memory.equals(that.memory) : that.memory != null) return false;
        if (storageMax != null ? !storageMax.equals(that.storageMax) : that.storageMax != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + idPlateform;
        result = 31 * result + (osLevel != null ? osLevel.hashCode() : 0);
        result = 31 * result + (osName != null ? osName.hashCode() : 0);
        result = 31 * result + (cpuQty != null ? cpuQty.hashCode() : 0);
        result = 31 * result + (coreSize != null ? coreSize.hashCode() : 0);
        result = 31 * result + (memory != null ? memory.hashCode() : 0);
        result = 31 * result + (storageMax != null ? storageMax.hashCode() : 0);
        return result;
    }
}
