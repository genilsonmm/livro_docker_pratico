`
FROM node
WORKDIR /app
COPY package*.json .
RUN npm install
COPY . .
EXPOSE 3000
CMD ["node", "index.js"]
#CMD ["npx", "nodemon"]
#CMD ["npm", "run", "dev"]
`

`
{
  "dependencies": {
    "express": "^4.18.2",
    "nodemon": "^3.0.2"
  },
  "scripts": {
    "start": "node index.js",
    "dev": "nodemon -L index.js"
  },
  "devDependencies": {
    "nodemon": "^3.0.2"
  }
}
`