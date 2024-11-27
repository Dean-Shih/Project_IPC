// Função para exibir a seção correta
function showSection(sectionId) {
    const sections = document.querySelectorAll(".content-section");
    const buttons = document.querySelectorAll(".tab-btn");

    sections.forEach(section => section.classList.remove("active"));
    buttons.forEach(button => button.classList.remove("active"));

    document.getElementById(sectionId).classList.add("active");
    document.querySelector(`[onclick="showSection('${sectionId}')"]`).classList.add("active");
}

// Função para simular o cadastro
function handleCadastro(event) {
    event.preventDefault();
    alert("Cadastro realizado com sucesso! Agora você pode fazer login.");
    
    // Simula o envio dos dados para uma API
    const userId = "12345";  // Exemplo de ID gerado no banco de dados
    document.getElementById("userId").value = userId;

    showSection("login");
}

// Função para simular o login
function handleLogin(event) {
    event.preventDefault();
    alert("Login realizado com sucesso!");

    // Habilita a aba de análise de perfil e redireciona o usuário
    document.getElementById("perfil-tab").disabled = false;
    showSection("perfil");
}

// Função para simular a análise de perfil
function handlePerfil(event) {
    event.preventDefault();

    // Coleta os investimentos selecionados pelo usuário
    const investimentosSelecionados = Array.from(document.querySelectorAll("input[name='investimentos']:checked"))
        .map(input => input.value);

    // Define o perfil com base nos investimentos selecionados
    let perfil;
    if (investimentosSelecionados.length === 0) {
        perfil = "Nenhum investimento selecionado";
    } else if (investimentosSelecionados.length <= 3) {
        perfil = "Iniciante";
    } else if (investimentosSelecionados.length <= 5) {
        perfil = "Moderado";
    } else {
        perfil = "Avançado";
    }

    // Exibe o resultado da análise de perfil
    alert(`Análise de perfil concluída! Seu perfil é: ${perfil}`);
}

// Inicia exibindo a seção de cadastro
document.addEventListener("DOMContentLoaded", () => {
    showSection("cadastro");
});

let ultimoScore = 0;

// Função para calcular o perfil de investimento
function handlePerfil(event) {
    event.preventDefault();

    const investimentosSelecionados = Array.from(document.querySelectorAll("input[name='investimentos']:checked"));
    const numInvestimentos = investimentosSelecionados.length;

    if (numInvestimentos === 0) {
        alert("Selecione pelo menos um investimento.");
        return;
    }

    // Calcula uma pontuação arbitrária para cada investimento
    const pontuacaoTotal = 1000;
    const pontuacaoPorInvestimento = pontuacaoTotal / numInvestimentos;

    // Define o score final como a média
    ultimoScore = pontuacaoPorInvestimento;

    // Habilita a aba de score
    document.getElementById("score-tab").disabled = false;
    showSection("score");

    // Atualiza o visual do score
    atualizarScore(ultimoScore);
}

// Atualiza a exibição do score
function atualizarScore(score) {
    const scoreCircle = document.querySelector(".score-circle");
    const scoreValue = document.getElementById("score-value");

    const scorePercentage = (score / 1000) * 100;
    scoreCircle.style.setProperty("--score-percentage", `${scorePercentage}%`);

    scoreValue.textContent = Math.round(score);
}

// Permite recalcular o score
function recalcularScore() {
    atualizarScore(ultimoScore);
}

// Configuração inicial
document.addEventListener("DOMContentLoaded", () => {
    showSection("cadastro");
});

