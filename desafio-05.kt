fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""

    // Aqui usamos a Extension Function "generateSlug()" nas Strings de Entrada.
    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()

    println("Slug gerado para o livro:")
    print("$slugTitulo")
    print("_")
    print("$slugAutor")
}

fun String.generateSlug(): String {
    var result = this.replace(" ", "-")
    result = result.replace(".", "")
    result = result.lowercase()
    return result
}
