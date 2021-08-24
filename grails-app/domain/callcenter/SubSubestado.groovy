package callcenter

class SubSubestado {

    String name
    boolean isActive
    Subestado subestado
    Estado estado
    String estadoPequeno
    String type

    static constraints = {
        String name
        Subestado subestado
        Estado estado
        estadoPequeno nullable: true
        type nullable: true
        type inList: ['Rellamada','Regestionable','Exitoso','No Exitoso','']
    }

    static mapping = {
        version false
    }
}
