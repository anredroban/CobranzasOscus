package callcenter

class Subestado {
	
	String nombre
	boolean enableManagement
	String type
	boolean isActive
	Estado estado
	String alias
	String estadoPequeno
	SubSubestado subSubestado

    static constraints = {
		enableManagement nullable: true
		type nullable: true
		type inList: ['Rellamada','Regestionable','Exitoso','Condonacion', 'No Exitoso','']
		isActive nullable: true
		alias nullable: true
		estadoPequeno nullable: true
    }
	
	static mapping = {
		version false
	}
	
}
