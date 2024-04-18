const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res)=>{
    res.json('Teste API node via container docker volumes')
})

app.listen(port, ()=> console.log(`Executando na porta ${port}`))