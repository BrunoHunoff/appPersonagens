import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.personagensapp.modelo.Personagem

@Composable
fun TelaDetalhe(navController: NavController, personagem: Personagem) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = personagem.nome,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(Modifier.height(8.dp))
            Text("Espécie: ${personagem.especie}", style = MaterialTheme.typography.bodyLarge)
            Text("Classe: ${personagem.classe}", style = MaterialTheme.typography.bodyLarge)
            Text("Level: ${personagem.level}", style = MaterialTheme.typography.bodyLarge)
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Voltar")
        }
    }
}
