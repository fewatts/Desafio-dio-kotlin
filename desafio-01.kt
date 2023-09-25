// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val email: String, val id: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}


fun main() {
    val usuario1 = Usuario("Spinnenkopf", "Spinnenkopf@email.com", 1)
    val usuario2 = Usuario("Tigerhead", "Tigerhead@email.com", 2)

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)
    val conteudo3 = ConteudoEducacional("Tópicos Avançados em Kotlin", 150)

    val formacaoKotlin = Formacao("Formação Kotlin", mutableListOf(conteudo1, conteudo2, conteudo3))

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    println("\nInscritos na Formação Kotlin:")
    for (usuario in formacaoKotlin.inscritos) {
        println("\nNome: ${usuario.nome}\nEmail: ${usuario.email}")
    }
}
