.PHONY: test stop build run iex
PROJECT_NAME = perseverance

stop:
	@docker stop ${PROJECT_NAME} || true && docker rm ${PROJECT_NAME}|| true
	@docker-compose down

build: stop
	@docker-compose build
	
run: stop
	@docker-compose up -d

logs:
	@docker logs ${PROJECT_NAME} -f 

