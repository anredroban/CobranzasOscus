package callcenter

class Agencia {
    String nombre
    Ciudad ciudad
    String calle
    String numero
    String transversal
    String gerentesAgencia
    static constraints = {
        nombre nullable: true
        calle nullable: true
        numero nullable: true
        transversal nullable: true
        gerentesAgencia nullable: true
    }
    static mapping = {
        version false
    }
}
