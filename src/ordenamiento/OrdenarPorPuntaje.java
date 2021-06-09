package ordenamiento;

import java.util.Comparator;

import modelo.Usuario;

public class OrdenarPorPuntaje implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		// TODO Auto-generated method stub
		return Integer.parseInt(o1.getP().getPuntaje()) - Integer.parseInt(o2.getP().getPuntaje()) ;
	}

}
