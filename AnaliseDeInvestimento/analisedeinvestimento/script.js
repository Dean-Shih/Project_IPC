// Função para exibir a seção correta
function showSection(sectionId) {
    const sections = document.querySelectorAll(".content-section");
    const buttons = document.querySelectorAll(".tab-btn");

    sections.forEach(section => section.classList.remove("active"));
    buttons.forEach(button => button.classList.remove("active"));

    document.getElementById(sectionId).classList.add("active");
    document.querySelector(`[onclick="showSection('${sectionId}')"]`).classList.add("active");
}

let usuarioId = 0;

// Função para simular o cadastro
async function handleCadastro(event) {
    event.preventDefault();

    const nome = document.getElementById("nome").value;
    const cpf = document.getElementById("cpf").value;
    const telefone = document.getElementById("telefone").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    const usuario = {
        nome: nome,
        cpf: cpf,
        telefone: telefone,
        email: email,
        senha: senha
    };

    try {
        const response = await fetch("http://localhost:8080/usuario", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(usuario)
        });

        if (response.ok) {
            alert("Usuário cadastrado com sucesso!");
            showSection('login');
        } else {
            const error = await response.text();
            alert("Erro: " + error);
        }
    } catch (error) {
        alert("Erro na comunicação com o servidor.");
    }
}

// Função para simular o login
async function handleLogin(event) {
    event.preventDefault();

    const cpf = document.getElementById("login-cpf").value;
    const senha = document.getElementById("login-senha").value;

    const usuarioLogin = {
        cpf: cpf,
        senha: senha
    };

    try {
        const response = await fetch("http://localhost:8080/usuario/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(usuarioLogin)
        });

        if (response.ok) {
            const data = await response.json();
            usuarioId = data["id"];
            alert("Login bem-sucedido!");
            document.getElementById("perfil-tab").disabled = false;
            showSection('perfil');
        } else {
            const error = await response.text();
            alert("Erro: " + error);
        }
    } catch (error) {
        // console.log(error);
        // alert("Erro na comunicação com o servidor.");
    }
}

// Inicia exibindo a seção de cadastro
document.addEventListener("DOMContentLoaded", () => {
    showSection("cadastro");
});

let ultimoScore = 0;

// Função para calcular o perfil de investimento
async function handlePerfil(event) {
    event.preventDefault();

    // Coleta os investimentos selecionados pelo usuário
    const investimentosSelecionados = Array.from(document.querySelectorAll("input[name='investimentos']:checked"))
        .map(input => input.value);

    const usuario = {
        investimentoIds: investimentosSelecionados,
    };

    try {
        const response = await fetch("http://localhost:8080/usuario/" + usuarioId + "/investimentos", {
            method: "PATCH",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(usuario)
        });

        if (response.ok) {
            showSection("score");
            ultimoScore = await calcularScore();
            console.log(ultimoScore);
            atualizarScore(ultimoScore);
        } else {
            alert("Erro ao obter perfil.");
            console.log(response.text());
        }
    } catch (error) {
        //alert("Erro na comunicação com o servidor.");
    }
}

async function calcularScore(){
    try{
        const response = await fetch("http://localhost:8080/usuario/" + usuarioId + "/score", {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            },
        });
        if(response.ok){
            let data = await response.json();
            console.log(data);
            return data;   
        }

    }catch (error) {
        //alert("Erro na comunicação com o servidor.");
    }
}

// Atualiza a exibição do score
async function atualizarScore(calculatedScore) {
    const scoreCircle = document.querySelector(".score-circle");
    const scoreValue = document.getElementById("score-value");
    scoreValue.textContent = Math.round(calculatedScore);
    scoreCircle.style.setProperty("--score-percentage", `${calculatedScore}%`);
    const usuario = {
        score: calculatedScore,
    };

    try{
        const response = await fetch("http://localhost:8080/usuario/" + usuarioId + "/score", {
            method: "PATCH",
            headers: {
                "Content-Type": "application/json"
            },
        });
    }catch (error) {
        //alert("Erro na comunicação com o servidor.");
    }
}

// Configuração inicial
document.addEventListener("DOMContentLoaded", () => {
    showSection("cadastro");
});

