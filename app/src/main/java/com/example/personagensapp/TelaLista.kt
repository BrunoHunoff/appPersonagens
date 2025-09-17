import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.personagensapp.modelo.Personagem
import com.google.gson.Gson

@Composable
fun TelaLista(navController: NavController) {
    val personagens = listOf(
        Personagem("Legolas", "Elfo", "Ranger", 12),
        Personagem("Gimli", "Anão", "Guerreiro", 11),
        Personagem("Gandalf", "Maia", "Mago", 20)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(personagens) { personagem ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val json = Gson().toJson(personagem)
                        navController.navigate("detalhe/$json")
                    },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = personagem.nome,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Espécie: ${personagem.especie}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
