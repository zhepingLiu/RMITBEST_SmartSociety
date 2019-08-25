<template>
  <div id="app">
    <!-- <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </div> -->
    <router-view/>
  </div>
</template>

<style>
*{
  margin: 0px;
  padding: 0px;
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

.fs14{
  font-size: 14px;
}

.fs16{
  font-size: 16px;
}

.fs18{
  font-size: 18px;
}

.fs20{
  font-size: 20px;
}

.fs22{
  font-size: 22px;
}

.mt16{
  margin-top: 16px;
}

.flex {
    display: -webkit-flex;
    /* Safari */
    -webkit-flex-wrap: wrap;
    /* Safari 6.1+ */
    display: flex;
    flex-wrap: wrap;
    flex-direction: row;
    justify-content: space-around;
}

.jcfs{
    justify-content: flex-start;
}

.jcct{
  justify-content: center;
}

.jcfe{
    justify-content: flex-end;
}

.flex-center{
    align-items: center;
    align-content: center;
}
</style>
