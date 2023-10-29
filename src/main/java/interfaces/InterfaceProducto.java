package interfaces;

import models.Productocl2;

import java.util.List;

public interface InterfaceProducto {
    public List<Productocl2> ListarProducto();
    public Productocl2 BuscarProducto(Integer id);
    public void AgregarProducto(Productocl2 productocl2);
    public void ActualizarProducto(Productocl2 productocl2);
    public void EliminarProducto(Integer id);
}
