package co.com.almundo.enums;

public enum EstadoEnum {

	ACTIVO(1L,"ACTIVO"),
	INACTIVO(2L,"INACTIVO"),
	ENESPERA(3l,"EN_ESPERA");
	
	private final Long id;
	
	private final String valor;
	
	EstadoEnum(Long id, String valor) {
		this.id = id;
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return id.toString();
	}
	
	public static EstadoEnum get(String nombre) {
		for (EstadoEnum estado : EstadoEnum.values()) {
			if (estado.getValor().equals(nombre)) {
				return estado;
			}
		}
		return null;
	}
}
