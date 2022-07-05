


public class datosFacturas {
    String cheque = "";
    String factura = "";
    String fechaReg = "";
    String monto = "";
    String abono = "";
    String fechaAbono = "";
    String total = "";
    String estado = "";
    String costoPro = "";
    String notas = "";
    
    public datosFacturas(){ 
    }
    
    public datosFacturas(String cheque, String factura, String fechaReg, String monto, String abono,
    String fechaAbono, String total, String estado, String costoPro, String notas){ 
        
        this.abono = abono;
        this.cheque = cheque;
        this.costoPro = costoPro;
        this.estado = estado;
        this.factura = factura;
        this.fechaAbono = fechaAbono;
        this.fechaReg = fechaReg;
        this.monto = monto;
        this.notas = notas;
        this.total = total;
        
    }

    public String getCheque() {
        return cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(String fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getAbono() {
        return abono;
    }

    public void setAbono(String abono) {
        this.abono = abono;
    }

    public String getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(String fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCostoPro() {
        return costoPro;
    }

    public void setCostoPro(String costoPro) {
        this.costoPro = costoPro;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
    
}
