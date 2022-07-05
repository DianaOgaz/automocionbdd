


public class datosProveedores {
  String nombreCorp = "";   
  String estado = "";   
  String calle = "";   
  String colonia = "";   
  String cp = "";   
  String rfc = "";   
  String curp = "";   
  String telefono = "";   
  String celular = "";   
  String notas = "";   
  
  public datosProveedores(){
      
  }
  public datosProveedores(String nombreCorp, String estado, String calle, String colonia, 
       String cp, String rfc, String curp, String telefono, String celular, String notas){
      this.calle = calle;
      this.celular = celular;
      this.colonia = colonia;
      this.cp = cp;
      this.curp = curp;
      this.estado = estado;
      this.nombreCorp = nombreCorp;
      this.notas = notas;
      this.rfc = rfc;
      this.telefono = telefono;
      
      
  }

    public String getNombreCorp() {
        return nombreCorp;
    }

    public void setNombreCorp(String nombreCorp) {
        this.nombreCorp = nombreCorp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
  
  
}
