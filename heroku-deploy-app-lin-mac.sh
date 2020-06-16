#!/usr/bin/env sh

heroku container:push web
heroku container:release web --app=geek-shopping-list