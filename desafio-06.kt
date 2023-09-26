import kotlin.concurrent.thread

fun main() {
    val urls = mutableListOf<String>()

    while (true) {
        val input = readLine() ?: break
        if (input.isBlank()) break
        urls.add(input)
    }

    println("Iniciando downloads...")

    // Cria uma lista de Pair (índice, tamanho)
    val results = mutableListOf<Pair<Int, Int>>()

    // Cria uma lista de threads para fazer downloads em paralelo
    val downloadThreads =
            urls.mapIndexed { index, url ->
                thread {
                    val length = openLink(url)
                    synchronized(results) { results.add(Pair(index, length)) }
                }
            }

    // Aguarda todas as threads de download serem concluídas
    downloadThreads.forEach { it.join() }

    // Ordena os resultados pelo índice para imprimir na ordem correta
    results.sortedBy { it.first }.forEachIndexed { idx, result ->
        println("Arq${idx + 1}: ${result.second}")
    }

    println("Tempo total: ${urls.size}")
}

fun openLink(url: String): Int {
    // Simule aqui o download real da URL
    // Substitua por uma lógica de download real
    Thread.sleep(1000) // Simulação de um segundo de download
    return url.length
}
