FROM node:18-alpine

WORKDIR /app

COPY package.json .

RUN npm install

COPY . .

ENV VITE_BACKEND_URL=http://localhost:8080

RUN npm run build

EXPOSE 3000

CMD [ "npm", "run", "preview" ]