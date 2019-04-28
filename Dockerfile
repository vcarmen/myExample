#base image
FROM ubuntu

#do image configuration
RUN /bin/bash -c 'echo This is an example'
ENV myCustomEnvVar="This is env example" \
    otherEnvVar="Thi is also env example"