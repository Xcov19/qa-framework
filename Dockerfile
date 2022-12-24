# docker machine issue? https://github.com/docker-archive/toolbox/issues/453
FROM selenium/standalone-chrome

ARG NOWUSER
ARG UID=1000
ENV CURRENT_USER=$NOWUSER
RUN echo $CURRENT_USER

RUN sudo useradd -u $UID $CURRENT_USER

WORKDIR /app

USER root

RUN apt install curl tar bash procps -y && apt autoclean
RUN mkdir -p ./Logs ./screenshots

USER $CURRENT_USER

COPY src ./src
COPY test-data ./test-data


