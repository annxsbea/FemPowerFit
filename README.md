# FemPowerFit

## Requisitos
- [] Registro e Acompanhamento de Suplementação
- [] Treinos Específicos para Ciclo Menstrual
- [] Calendário de Treinos e Atividades
- [] Avaliação de Progresso
- [] Autenticação

## EndPoints

### Suplementação

`GET` /suplementos

Obter a lista de todos os suplementos registrados.

`200` sucesso

---

`GET` /suplementos/{id}

Retorna o Suplemento informado através do `id`

**Códigos de Status da Resposta:**

`200`- sucesso

`404` - id não encontrado

---

`POST` /suplementos

Registra o suplemento usado pelo usuário.

Adicionando um novo Suplemento.

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|-----------
|nome|string|✅|Um nome curto para identificar o suplemento
|lembrete|string|❌| Uma notificação que lembrará o usuário de ingerir o suplemento

**Código de Status**

`200` - sucesso

`400` - falha na validação

---

`DELETE` /suplementos/{id}

Deleta o suplemento com o id especificado.

**Código de Status**

`204` - excluído com sucesso

`404` - não encontrado

---

`PUT` /suplementos/{id}

Atualiza o suplemento com o `id` específicado.

Corpo da Requisição:

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|-----------
|nome|string|✅|Novo nome do suplemento
|icone|string|❌|Novo lembrete para garantir consistência na ingestão

**Código de Status**

`200` - Sucesso

`404` - não encontrado

`400` - falha na validação

---

### Treinos
 `GET` /treinos/{frase_ciclo}

 Obter programa de treinamentos ajustados para uma determinada fase do ciclo menstrual.

 **Códigos de Status**

 `200` - sucesso
 
 `404` - não encontrado

 ---

 ### Calendário

 `GET` /calendario/{data}

 Obter eventos de treino e atividades planejados para uma data específica.

**Código de Status**

`200` - sucesso

`404` - não encontrado

---

### Avaliação do Progresso

`GET` /progresso

Obter ferramentas para avaliação de progresso, como medidas corporais, peso, fotos e desempenho nos treinos.

**Códigos de Status**

`200` - sucesso
