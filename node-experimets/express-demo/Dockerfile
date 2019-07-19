FROM node:9-slim
workdir /app
COPY package.json /app
RUN npm install
COPY . /app
CMD ["npm","start"]