FROM node
WORKDIR /app
COPY package*.json .
RUN npm install
COPY . .
EXPOSE 3000
CMD ["node", "index.js"]
#CMD ["npx", "nodemon"]
#CMD ["npm", "run", "dev"]