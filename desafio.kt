// Entrega do desafio DIO
// Andre Mazzali

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nomeUsuario: String, val matriculaUsuario : Int) {
    override fun toString(): String {
        return "$nomeUsuario - matricula $matriculaUsuario"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    override fun toString() : String {
        return "$nome, com duração de $duracao"
    }
}

data class Formacao(val nome: String,var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.addAll(usuario)
    }
    
    override fun toString(): String {
        //Organiza o retorno para o usuário visualizar a saída do programa
        return """
        Curso: $nome    Conteúdo: $conteudos
        Nível: $nivel
        Alunos inscritos: $inscritos
        """
    }
}

fun main() {
   // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
   //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
   
   val andre = Usuario("Andre", 1)
   val fabiana = Usuario("Fabiana", 2)
   val nick = Usuario("Nick", 3)
   val dara = Usuario("Dara", 4)
   val july = Usuario("July", 5)
   val lucy = Usuario("Lucy", 6)
   val lana = Usuario("Lana", 7)
   val panda = Usuario("Panda", 8)
   
   val conteudoAngular = ConteudoEducacional("Curso Angular", 120)
   val conteudoKotlin = ConteudoEducacional("Curso Kotlin Back-End", 52)
   val conteudoGit = ConteudoEducacional("Git", 10)
   val conteudoAgile = ConteudoEducacional("Agile", 60)
   
   val formacaoKotlin = Formacao("Kotlin", listOf(conteudoKotlin), Nivel.AVANCADO)
   val formacaoAngular = Formacao("Angular", listOf(conteudoAngular), Nivel.INTERMEDIARIO)
   val formacaoGit = Formacao("Git", listOf(conteudoGit), Nivel.BASICO)
   val formacaoAgile = Formacao("Agile", listOf(conteudoAgile), Nivel.INTERMEDIARIO)
   
   formacaoAngular.matricular(andre, fabiana, lana)
   formacaoKotlin.matricular(andre, nick, dara, lana)
   formacaoGit.matricular(andre, july, panda, lucy)
   formacaoAgile.matricular(andre, fabiana, lana, nick, panda, lucy, july, dara)
   
   println(formacaoKotlin)
   println(formacaoAngular)
   println(formacaoGit)
   println(formacaoAgile)
}