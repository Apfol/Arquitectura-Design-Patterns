package fly_weight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import adapter.Usuario;
import facade.*;

public class FlyWeightFactory {
	
	private static FlyWeightFactory fabrica;
	private HashMap usBasicInf = new HashMap();
	private static Facade facade;
	
	public FlyWeightFactory() {
		// TODO Auto-generated constructor stub
		facade = Facade.getFacadeInstance();
		this.cargarUsuarios();
	}
	

	
	public void eliminarUs(String documento)
	{
		usBasicInf.remove(documento);
	}
	
	public IFlyWeight obtenerUsuario(String documento)
	{
		IFlyWeight us =(IFlyWeight)usBasicInf.get(documento);
		
		return us;
	}
	
	public void cargarUsuarios() {
		//usBasicInf.clear();
		for(IFlyWeight flyWeightUs: facade.getUsuarios())
		{
			usBasicInf.put(flyWeightUs.getDocumento(), flyWeightUs);
		}

	}

	public void añadirUsuario(IFlyWeight usEspe)
	{
		
		if(!usBasicInf.containsKey(usEspe.getDocumento()))
		{
			usBasicInf.put(usEspe.getDocumento(), usEspe);
		}else
		{
			JOptionPane.showMessageDialog(null,  "El usuario ya existe");
		}
		
	}
	
	public String mostrarUsuarios()
	{
		String cadena = "";
		Iterator iterator = usBasicInf.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry pair = (Map.Entry)iterator.next();
			cadena += pair.getKey().toString() +" = "+ ((IFlyWeight)pair.getValue()).getNombre() +"\n";
		}
		return	cadena;
	}

}
